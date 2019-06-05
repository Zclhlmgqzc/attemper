package com.github.attemper.common.param.sys.tag;

import com.github.attemper.common.param.CommonParam;
import lombok.Data;
import org.apache.commons.lang.StringUtils;

import java.util.List;

/**
 * @author ldang
 */
@Data
public class TagTenantSaveParam implements CommonParam {

    protected String tagName;

    protected List<String> userNames;

    public String validate() {
        if(StringUtils.isBlank(tagName)) {
            return "5300";
        }
        return null;
    }

}