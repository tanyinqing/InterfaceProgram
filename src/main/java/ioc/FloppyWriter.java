package ioc;



//ÈíÅÌÇı¶¯Æ÷  µ×²ãÄ£¿éÀà
public class FloppyWriter implements DeviceWriter{ //Floppy

    @Override
    public void saveToDevice() {
        System.out.println("save date to Floppy..");
    }
}
