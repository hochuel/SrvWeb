package com.srv.main.service.dao;

import com.srv.main.vo.TbMsgVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MessageDao {
    public int insertTbMsg(TbMsgVO vo) throws Exception;
}
