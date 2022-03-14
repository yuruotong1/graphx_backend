package com.dongle.graphx.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dongle.graphx.antlr.GraphxVisitor;
import com.dongle.graphx.antlr.code.GraphxGrammarLexer;
import com.dongle.graphx.antlr.code.GraphxGrammarParser;
import com.dongle.graphx.utils.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

import static com.dongle.graphx.utils.TempFile.deleteDir;

@RestController
@RequestMapping("/graph")
public class GraphController {
    private static final Logger LOGGER = LoggerFactory.getLogger(GraphController.class);
    @Value("${frontEndAddress}")
    private String frontEndAddress;



    @RequestMapping("/parse")
    @GetMapping
    public Object getParseResultFromBrowser(@RequestParam(value = "data", defaultValue = "") String data) {
        LogUtil.info(LOGGER, "string parse", data);
        return new ModelAndView("redirect:" + frontEndAddress + Constant.FRONT_REDIRECT_URL + data);
    }

    @RequestMapping("/parseBase64")
    @GetMapping
    public Object getParseBase64Result(@RequestParam(value = "data", defaultValue = "") String data) {
        LogUtil.info(LOGGER, "starting parse base64");
        if (data.endsWith(Constant.SUFFIX_PNG)) {
            data = data.substring(0, data.length() - 4);
        }
        JSONObject dataObj = decodeBase64Url(data);
        File tempDir = TempFile.createDir();
        JSONObject res = packageRes(dataObj.getJSONArray(Constant.NODE_LIST), dataObj.getString(Constant.RAW_DATA));
        res.getJSONObject(Constant.GRAPH_DATA).put(Constant.RAW_DATA, dataObj.getString(Constant.RAW_DATA));
        TempFile.deleteDir(tempDir);
        return res;
    }

    @RequestMapping(value = "/png", produces = MediaType.IMAGE_PNG_VALUE)
    @GetMapping
    @ResponseBody
    public byte[] getParsePngResult(@RequestParam(value = "data", defaultValue = "") String data) {
        LogUtil.info(LOGGER, "png", data);
        if (data.endsWith(Constant.SUFFIX_PNG)) {
            data = data.substring(0, data.length() - 4);
        }
        JSONObject dataObj = decodeBase64Url(data);
        File tempDir = TempFile.createDir();
        JSONObject parseResult = parseData(dataObj.getString(Constant.RAW_DATA), dataObj.getJSONArray(Constant.NODE_LIST), tempDir);
        GraphvizDot graphvizDotObj = (GraphvizDot) parseResult.get(Constant.GRAPHVIZ_DOT_OBj);
        return graphvizDotObj.getPngBytes();
    }

    @RequestMapping("/parseData")
    @PostMapping
    public JSONObject getParseResult(@RequestBody String requestDataString) {
        JSONObject requestDataObj = JSON.parseObject(requestDataString);
        String rawData = (String) requestDataObj.get(Constant.RAWDATA);
        JSONObject requestGraphData = requestDataObj.getJSONObject(Constant.JSON_DATA);
        JSONArray requestNodes = requestGraphData.getJSONArray(Constant.NODE_LIST);
        LogUtil.info(LOGGER, "receive parse data", requestDataObj.toJSONString());
        JSONObject res = packageRes(requestNodes, rawData);
        LogUtil.info(LOGGER, "return data", res.toJSONString());
        return res;
    }

    private JSONObject packageRes(JSONArray requestNodes, String rawData) {
        File tempDir = TempFile.createDir();
        JSONObject res = new JSONObject();
        JSONObject parseResult = parseData(rawData, requestNodes, tempDir);
        GraphvizDot graphvizDotObj = (GraphvizDot) parseResult.get(Constant.GRAPHVIZ_DOT_OBj);
        JSONObject graphData = new JSONObject();
        graphData.put(Constant.IMG, graphvizDotObj.getBase64());
        graphData.put(Constant.NODE_LIST, parseResult.getJSONArray(Constant.NODE_LIST));
        graphData.put(Constant.BASE64, encodeBase64Url(rawData, parseResult.getJSONArray(Constant.NODE_LIST)) + Constant.SUFFIX_PNG);
        res.put(Constant.GRAPH_DATA, graphData);
        res.put(Constant.SUCCESS, true);
        TempFile.deleteDir(tempDir);
        return res;
    }


    public String encodeBase64Url(String rawData, JSONArray nodeList) {
        JSONObject data = new JSONObject();
        data.put(Constant.RAW_DATA, rawData);
        data.put(Constant.NODE_LIST, nodeList);
        return Base64.getUrlEncoder().encodeToString(data.toJSONString().getBytes());
    }

    public JSONObject decodeBase64Url(String base64Data) {
        byte[] decode = Base64.getUrlDecoder().decode(base64Data);
        return (JSONObject) JSONObject.parse(decode);
    }

    public JSONObject parseData(String rawData, JSONArray requestNodes, File tempDir) {
        GraphvizDot graphvizDot = new GraphvizDot(tempDir);
        CharStream codePointCharStream = CharStreams.fromString(rawData);
        GraphxGrammarLexer lexer = new GraphxGrammarLexer(codePointCharStream);
        GraphxGrammarParser parser = new GraphxGrammarParser(new CommonTokenStream(lexer));
        GraphxGrammarParser.StatContext tree = parser.stat();
        GraphxVisitor eval = new GraphxVisitor(requestNodes, graphvizDot);
        JSONArray nodeArray = new JSONArray();
        JSONObject res = new JSONObject();
        try {
            JSONObject parseRes = (JSONObject) eval.visit(tree);
            nodeArray = parseRes.getJSONArray(Constant.NODE_LIST);
        } catch (Exception e) {
            LogUtil.error(LOGGER, e);
        }
        res.put(Constant.GRAPHVIZ_DOT_OBj, graphvizDot);
        res.put(Constant.NODE_LIST, nodeArray);
        return res;
    }
}
