package com.hopu.result;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hopu.domain.TRole;

public class PageEntity {
    private int code=0;
    private String msg;
    private int count;
    private Object data;

    public PageEntity(){

    }

    public PageEntity(int count,Object data){
        this.count=count;
        this.data=data;
    }

    public PageEntity(IPage<?> page){
        this.count= (int) page.getTotal();
        this.data=page.getRecords();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
