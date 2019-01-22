package org.xxf.temple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xxf.temple.query.spring.ControllerQuery;
import org.xxf.temple.service.ISpringService;
import org.xxf.temple.util.Result;
import org.xxf.temple.util.ResultCode;
import org.xxf.temple.util.ResultUtil;

import javax.validation.Valid;

/**
 *
 * @author: xxf
 * @date: 2019/1/22 0022 下午 3:12
 */
@RestController
@RequestMapping(value = "/spring")
public class SpringController {
    @Autowired
    private ISpringService springService;

    @GetMapping(value = "/v1/controller")
    public Result<Object> createControllerFile(@Valid ControllerQuery query, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return ResultUtil.putError(ResultCode.ILLEGAL_ARGUMENT,bindingResult.getFieldError().getDefaultMessage());
        }

        try{
            springService.createController(query);
            return ResultUtil.success(true);
        }catch(Exception e){
            e.printStackTrace();
            return ResultUtil.putError(ResultCode.SYSTEM_ERROR,e.getMessage());
        }
    }

}
