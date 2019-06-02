package com.github.attemper.common.param.dispatch.arg;

import com.github.attemper.common.param.PageSortParam;
import lombok.Data;

@Data
public class ArgListParam extends PageSortParam {

    protected String argName;

    protected Integer argType;

    protected String argValue;

    protected String remark;
}
