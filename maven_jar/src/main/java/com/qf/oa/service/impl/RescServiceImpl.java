package com.qf.oa.service.impl;

import com.qf.oa.dao.RescMapper;
import com.qf.oa.dao.RoleMapper;
import com.qf.oa.entity.Resc;
import com.qf.oa.service.IRescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RescServiceImpl implements IRescService {
    @Autowired
    private RescMapper rescMapper;

    @Autowired
    private RoleMapper roleMapper;

    public List<Resc> queryAll() {
        return rescMapper.queryAll();
    }

    public void insertResc(Resc resc) {
        rescMapper.insert(resc);
    }

    public List<Resc> queryresc(Integer rid) {
        return rescMapper.queryresc(rid);
    }

    public int updateRescAndRole(Integer rid, Integer[] reids) {
        roleMapper.deleteRoleRescTable(rid);

        return rescMapper.insertRoleAndResc(rid, reids);
    }
}
