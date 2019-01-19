package org.xxf.temple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xxf.temple.query.NettyQuery;
import org.xxf.temple.service.IHandlerService;
import org.xxf.temple.util.Result;
import org.xxf.temple.util.ResultCode;
import org.xxf.temple.util.ResultUtil;

import javax.validation.Valid;

/**
 * @author: xxf
 * @date: 2019/1/19 0019 下午 3:09
 */
@RestController
@RequestMapping(value = "/handler")
public class HandlerController {
    @Autowired
    private IHandlerService handlerService;

    @GetMapping(value = "/v1/netty")
    public Result<Object> nettyHandler(@Valid NettyQuery query, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return ResultUtil.putError(ResultCode.ILLEGAL_ARGUMENT,bindingResult.getFieldError().getDefaultMessage());
        }

        try{
            String temple = handlerService.nettyHandler(query);
            return ResultUtil.success(temple);
        }catch(Exception e){
            e.printStackTrace();
            return ResultUtil.putError(ResultCode.SYSTEM_ERROR,e.getMessage());
        }
    }

}
