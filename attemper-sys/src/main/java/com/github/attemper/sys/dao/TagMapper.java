package com.github.attemper.sys.dao;

import com.github.attemper.common.base.BaseMapper;
import com.github.attemper.common.result.sys.tag.Tag;
import com.github.attemper.common.result.sys.tenant.Tenant;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface TagMapper extends BaseMapper<Tag> {

    List<Tenant> getTenants(Map<String, Object> paramMap);

    void deleteTenants(Map<String, Object> paramMap);

    void addTenants(Map<String, Object> paramMap);

    List<String> getResources(Map<String, Object> paramMap);

    void deleteResources(Map<String, Object> paramMap);

    void addResources(Map<String, Object> paramMap);
}