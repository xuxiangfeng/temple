package <<packageStr>>.controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import <<packageStr>>.query.BaseQuery;
import <<packageStr>>.util.Result;
import <<packageStr>>.util.ResultCode;
import <<packageStr>>.util.ResultUtil;

import javax.validation.Valid;

/**
 * <<commit>>
 * @author: xxf
 * @date: <<date>>
 */
@RestController
@RequestMapping(value = "")
public class <<name::controllerName>> {

    @PostMapping(value = "")
    public Result<Object> index(@Valid BaseQuery query, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return ResultUtil.putError(ResultCode.ILLEGAL_ARGUMENT,bindingResult.getFieldError().getDefaultMessage());
        }

        try{
            return ResultUtil.success(true);
        }catch(Exception e){
            e.printStackTrace();
            return ResultUtil.putError(ResultCode.SYSTEM_ERROR,e.getMessage());
        }
    }

}