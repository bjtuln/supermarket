/**
 * Created by Administrator on 2016/7/18.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


class goodInFo{
    //存储商品信息
    static ArrayList<String> array_goodinfo=new ArrayList<String>();
    /**
     * 以行为单位读取商品信息文件存储在array_goodinfo
     */
    public static ArrayList read_GoodInfo(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        array_goodinfo.clear();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            // 一次读入一行，直到读入null为文件结束
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
        return array_goodinfo;
    }

}

class promotionInFo{
    //存储优惠商品信息(买三免一)
    static ArrayList<String> array_promotioninfo=new ArrayList<String>();
    /**
     * 以行为单位读取商品信息文件存储在array_goodinfo
     */
    public static ArrayList read_PromotionInfo(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        array_promotioninfo.clear();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                array_promotioninfo.add(tempString);
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
        return array_promotioninfo;
    }
}
class discountInFo {
    //95折商品
    static ArrayList<String> array_discountinfo = new ArrayList<String>();
    /**
     * 以行为单位读取商品信息文件存储在array_goodinfo
     */
    public static ArrayList<String> read_DiscountInfo(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        array_discountinfo.clear();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                array_discountinfo.add(tempString);
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
        return array_discountinfo;
    }
}
class purchaseInFo{
    static ArrayList<String> array_purchaseinfo=new ArrayList<String>();
    static ArrayList<Integer> array_purchaseinfo_num=new ArrayList<Integer>();
    static String[] str_goodInFo=new String[6];
    static int num=0;
    static float all_money=0;
    static float all_moneyCharge=0;
    static float ltt=0;
    public void set_Array(String a, int b){
        array_purchaseinfo.add(a);
        array_purchaseinfo_num.add(b);
    }
    //计算正常商品
    public static float calculate_NormalInfo()
    {
        System.out.println("*<没钱赚商店>购物清单*");

        //去掉最后一个"#"
        for(int i=0;i<array_purchaseinfo.size()-1;i++)
        {
            boolean ifpurchase=false;
            int num=0;
            for(int j=0;j<promotionInFo.array_promotioninfo.size();j++)
            {
                //如果是促销商品
                if(array_purchaseinfo.get(i).trim().equals(promotionInFo.array_promotioninfo.get(j).trim()))
                    ifpurchase=true;
            }
            for(int k=0;k<goodInFo.array_goodinfo.size();k++)
            {
                str_goodInFo=goodInFo.array_goodinfo.get(k).split("\\s+",6);
                if(ifpurchase)
                    num=array_purchaseinfo_num.get(i)-array_purchaseinfo_num.get(i)/3;
                else {
                    num=array_purchaseinfo_num.get(i);
                }
                if(array_purchaseinfo.get(i).equals(str_goodInFo[0]))
                {
                    System.out.println("名称："+str_goodInFo[1]+"，数量："+array_purchaseinfo_num.get(i)+str_goodInFo[2]+"，单价："+str_goodInFo[5]+"(元)，"+"小计："+num* Float.parseFloat(str_goodInFo[5])+"(元)。");
                    all_money+=array_purchaseinfo_num.get(i)*Float.parseFloat(str_goodInFo[5]);
                    ltt=num* Float.parseFloat(str_goodInFo[5]);
                }
            }
        }
        return ltt;
    }


    //计算促销商品
    public static float calculate_PromotionInfo()
    {
        boolean flag=true;
        //标记要不要输出买三免一

        //去掉最后一个"#"
        for(int i=0;i<array_purchaseinfo.size()-1;i++)
        {
            //如果是促销产品的计算
            for(int j=0;j<promotionInFo.array_promotioninfo.size();j++)
            {
                if(array_purchaseinfo.get(i).trim().equals(promotionInFo.array_promotioninfo.get(j).trim()))
                {
                    if(flag)
                    {
                        System.out.println("买三免一商品");
                        flag=false;
                    }
                    for(int k=0;k<goodInFo.array_goodinfo.size();k++)
                    {
                        //得到字符串的第一个空格
                        str_goodInFo=goodInFo.array_goodinfo.get(k).split("\\s+",6);
                        if(array_purchaseinfo.get(i).equals(str_goodInFo[0]))
                        {
                            //输出后面的信息
                            float forCharge=0;
                            forCharge=array_purchaseinfo_num.get(i)/3;
                            System.out.println("名称："+str_goodInFo[1]+"，数量："+forCharge+"。");
                            all_moneyCharge+=forCharge*Float.parseFloat(str_goodInFo[5]);
                        }
                    }
                    System.out.println("节省："+all_moneyCharge+"(元)。");


                }
            }

        }
        return all_moneyCharge;
    }
    //计算95折
    public static float calculate_DiscountInfo(ArrayList<String> dis){
        float discount_sum =  0;
        for(int i=0;i<array_purchaseinfo.size()-1;i++)
        {
            num=array_purchaseinfo_num.get(i);
            //如果是95折产品的计算
            for(int j=0;j<dis.size();j++) {
                if (array_purchaseinfo.get(i).trim().equals(dis.get(j).trim())) {
                    for(int k=0;k<goodInFo.array_goodinfo.size();k++) {
                        str_goodInFo = goodInFo.array_goodinfo.get(k).split("\\s+", 6);
                        if (array_purchaseinfo.get(i).equals(str_goodInFo[0])) {
                            System.out.println("名称：" + str_goodInFo[1] + "，数量：" + array_purchaseinfo_num.get(i) + str_goodInFo[2] + "，单价：" + str_goodInFo[5] + "(元)，" + "小计：" + num * Float.parseFloat(str_goodInFo[5]) * 0.95 + "(元)，" + "节省：" + num * Float.parseFloat(str_goodInFo[5]) * 0.05 + "(元)");
                            discount_sum += num * Float.parseFloat(str_goodInFo[5]) * 0.05;
                        }
                    }
                }
            }
        }
        return discount_sum;
    }
    public static String calculate_AllInfo()
    {
        System.out.println("总计："+String.valueOf(all_money-all_moneyCharge)+"(元)。");
        return String.valueOf(all_money-all_moneyCharge);
    }
}

public class Info {
    public static void input_purchase(){
        //购买商品信息
        BufferedReader bf_purchaseinfo=new BufferedReader(new InputStreamReader(System.in));
        String str_purchaseinfo=null;
        int all_num=0;
        try {
            //在一行里面输入数据
            //输入格式ITEM000001或ITEM000005-2
            //可以多行输入，每行一个商品，"#"表示结束
            do {
                int count=1;
                str_purchaseinfo=bf_purchaseinfo.readLine();
                if(str_purchaseinfo.length()>10)
                {
                    String[] split_purchaseinfo;
                    split_purchaseinfo=str_purchaseinfo.split("-");
                    str_purchaseinfo=split_purchaseinfo[0];
                    count=Integer.parseInt(split_purchaseinfo[1]);
                }
                if(purchaseInFo.array_purchaseinfo.contains(str_purchaseinfo))
                {
                    for(int i = 0;i < purchaseInFo.array_purchaseinfo_num.size(); i++){
                        if(purchaseInFo.array_purchaseinfo.get(i).equals(str_purchaseinfo))
                        {
                            all_num=purchaseInFo.array_purchaseinfo_num.get(i);
                        }
                    }//返回位置的内容
                    purchaseInFo.array_purchaseinfo_num.set(purchaseInFo.array_purchaseinfo.indexOf(str_purchaseinfo), ++all_num);
                }
                else {
                    //否则不包含，插入，修改num值为1
                    purchaseInFo.array_purchaseinfo.add(str_purchaseinfo);
                    purchaseInFo.array_purchaseinfo_num.add(count);

                }
            } while (!str_purchaseinfo.equals("#"));//最后一个商品为"#"
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //全部商品信息
        String file_GoodInfo = "src/main/resources/test-goodInfo.txt";
        goodInFo.read_GoodInfo(file_GoodInfo);
        for (int i = 0; i < goodInFo.array_goodinfo.size(); i++) {
            System.out.println(goodInFo.array_goodinfo.get(i));
        }
        //优惠商品信息
        String file_PromotionInfo = "src/main/resources/test-promotionInfo.txt";
        promotionInFo.read_PromotionInfo(file_PromotionInfo);
        for (int i = 0; i < promotionInFo.array_promotioninfo.size(); i++) {
            System.out.println(promotionInFo.array_promotioninfo.get(i));
        }
        ArrayList<String> dis = discountInFo.read_DiscountInfo("src/main/resources/discountInfo.txt");
        input_purchase();
        purchaseInFo.calculate_NormalInfo();
        purchaseInFo.calculate_DiscountInfo(dis);
        purchaseInFo.calculate_PromotionInfo();
        purchaseInFo.calculate_AllInfo();

    }

}
