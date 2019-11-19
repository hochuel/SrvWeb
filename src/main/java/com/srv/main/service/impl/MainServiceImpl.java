package com.srv.main.service.impl;

import com.srv.main.service.MainService;
import com.srv.main.service.dao.MessageDao;
import com.srv.main.vo.TbMsgVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("mainService")
public class MainServiceImpl implements MainService {

    @Autowired
    private MessageDao messageDao;

    @Override
    public int insertTbMsg(TbMsgVO vo) throws Exception {
        return messageDao.insertTbMsg(vo);
    }
}
