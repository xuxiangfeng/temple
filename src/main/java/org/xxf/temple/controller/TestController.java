package org.xxf.temple.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xxf.temple.util.Result;
import org.xxf.temple.util.ResultUtil;

/**
 * @author: xxf
 * @date: 2019/1/19 0019 上午 11:42
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @GetMapping(value = "/v1/test")
    public Result<Boolean> index(){
        return ResultUtil.success(true);
    }

}
