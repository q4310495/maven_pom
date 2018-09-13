package com.qf.oa.service;

import com.qf.oa.entity.DepCount;
import com.qf.oa.entity.Sex;

import java.util.List;

public interface ICotService {
    Sex cotBySex();

    List<DepCount> cotByDep();
}
