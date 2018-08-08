package ioc;


/**
 * 商务类  高层应用类 调用底层模块
 * 构造方法或set方法两种实现方式
 */
public class Business {

private DeviceWriter deviceWriter;//接口实现类

    public Business(DeviceWriter deviceWriter) {
        this.deviceWriter = deviceWriter;
    }

    public  void saveData(){
        this.deviceWriter.saveToDevice();
    }



//    public void setDeviceWriter(DeviceWriter1 deviceWriter) {
//        this.deviceWriter = deviceWriter;
//    }
}
