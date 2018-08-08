package model;

import java.util.List;

/**
 * 分页类的封装
 *
 * @author 传智.郭嘉
 */
public class DownData<T> {
    private String limit;    // 当前页数
    private String msg; // 总记录数
    private String success; // 总页数
    private T data;    // 每页显示的记录数
//    private List<T> list; // 每页显示数据的集合  运用了泛型.


    public DownData() {
    }

    public DownData(String limit, String msg, String success, T data) {
        this.limit = limit;
        this.msg = msg;
        this.success = success;
        this.data = data;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
