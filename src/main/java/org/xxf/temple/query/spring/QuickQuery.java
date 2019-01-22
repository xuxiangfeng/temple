package org.xxf.temple.query.spring;

import lombok.Data;

/**
 * @author: xxf
 * @date: 2019/1/22 0022 下午 5:44
 */
@Data
public class QuickQuery {

    private String packageStr;
    private String commit;
    private String name;
    private String date;

    public ControllerQuery toController(){
        ControllerQuery query = new ControllerQuery();
        query.setCommit(commit);
        query.setDate(date);
        query.setName(name);
        query.setPackageStr(packageStr);
        return query;
    }

    public ServiceQuery toService(){
        ServiceQuery query = new ServiceQuery();
        query.setCommit(commit);
        query.setDate(date);
        query.setName(name);
        query.setPackageStr(packageStr);
        return query;
    }

    public IServiceQuery toISerivce(){
        IServiceQuery query = new IServiceQuery();
        query.setCommit(commit);
        query.setDate(date);
        query.setName(name);
        query.setPackageStr(packageStr);
        return query;
    }

}
