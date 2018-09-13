package com.qf.oa.service.impl;

import com.qf.oa.dao.RoleMapper;
import com.qf.oa.entity.Role;
import com.qf.oa.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private RoleMapper roleMapper;
    public List<Role> queryAll() {
        List<Role> roles = roleMapper.queryAll();
        return roles;
    }

    public List<Role> queryRoleById(Integer eid) {
        return  roleMapper.queryRoleById(eid);

    }

    public int selectroles(Integer eid, Integer[] rid) {
        roleMapper.deleteByEid(eid);
        return roleMapper.selectroles(eid,rid);
    }

    public int insertRole(Role role) {
        return roleMapper.insert(role);
    }
}
