import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Administrator on 2016/7/17.
 */
public class FileIn {
    public FileIn() {
    }

    /*
    * 临时商品信息
    * */
    //控制台商品条码
    public String read_GoodInfo_console (String userInput) {
        return "ITEM000001";
    }

    //单数据文件
    public String read_GoodInfo () {
        File file = new File("goodInfo.txt");
        BufferedReader reader = null;
        String tempString = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            tempString = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return tempString;
    }


    //多数据文件
    static ArrayList<String> array_goodinfo=new ArrayList<String>();

    public String read_GoodInfo5 () {
        File file = new File("goodInfo5.txt");
        BufferedReader reader = null;
        String tempString = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((tempString = reader.readLine()) != null) {
                array_goodinfo.add(tempString);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return array_goodinfo.get(3);
    }

    /*
    * 促销商品信息1.95折
    * */
    static ArrayList<String> array_purinfo1=new ArrayList<String>();

    public String read_purinfo1_5 () {
        File file = new File("purInfo1.txt");
        BufferedReader reader = null;
        String tempString = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((tempString = reader.readLine()) != null) {
                array_purinfo1.add(tempString);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return array_purinfo1.get(3);
    }

    /*
    * 促销商品信息2.买三付二
    * */
    static ArrayList<String> array_purinfo2=new ArrayList<String>();

    public String read_purinfo2_5 () {
        File file = new File("purInfo2.txt");
        BufferedReader reader = null;
        String tempString = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((tempString = reader.readLine()) != null) {
                array_purinfo2.add(tempString);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return array_purinfo2.get(3);
    }
}
