package com.zmj.srb.core.controller.api;


import com.zmj.srb.common.result.R;
import com.zmj.srb.core.pojo.entity.Dict;
import com.zmj.srb.core.service.DictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 数据字典 前端控制器
 * </p>
 *
 * @author zhumengjun
 * @since 2023-11-07
 */
@Api(tags = "数据字典管理")
@RestController
//@CrossOrigin
@RequestMapping("/api/core/dict")
@Slf4j
public class DictController {

    @Resource
    private DictService dictService;

    @ApiOperation("根据dictCode获取下级节点")
    @GetMapping("/listByDictCode/{dictCode}")
    public R listByDictCode(
            @ApiParam(value = "节点编码",required = true)
            @PathVariable String dictCode){
        List<Dict> list =dictService.listByDictCode(dictCode);
        return R.ok().data("dictList",list);
    }
}

