package com.dongle.graphx.Dao;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dongle.graphx.Domain.Node;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface NodeDao extends BaseMapper<Node> {
}
