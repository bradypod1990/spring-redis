package com.feng.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.junit.Test;

public class TestA {
	
	
	@Test
    public void testHttp() {
        //���� POST ����
        String sr=TestA.sendPost("http://localhost/service", "{\"func\":\"getOrderResult\",\"req_data\":{\"key\":\"005010375989_A0D095_1454135733511\"}}");
        System.out.println(sr);
        List<String> list = new ArrayList<String>();
    }

    /**
     * ��ָ�� URL ����POST����������
     *
     * @param url
     *            ��������� URL
     * @param param
     *            ��������������Ӧ���� name1=value1&name2=value2 ����ʽ��
     * @return ����Զ����Դ����Ӧ���
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // �򿪺�URL֮�������
            URLConnection conn = realUrl.openConnection();
            
            // ����ͨ�õ���������
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("content-type", "text/html");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // ����POST�������������������
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // ��ȡURLConnection�����Ӧ�������
            out = new PrintWriter(conn.getOutputStream());
            // �����������
            out.print(param);
            // flush������Ļ���
            out.flush();
            // ����BufferedReader����������ȡURL����Ӧ
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(),"UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("���� POST ��������쳣��"+e);
            e.printStackTrace();
        }
        //ʹ��finally�����ر��������������
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }
    @Test
    public void test1() {
    	 Object o = new Object() {  			
             public boolean equals(Object obj) {  
                 return true; 
         }
     };   
     System.out.println(o.equals("Fred"));
     double[] a;
     
    }

    @Test
    public void t () {
    	//System.out.println("value="+switchit(4));//3
    }
    
    
    public static int switchit(int x) {
        int j=1;
        switch (x) {
        case 1:
        	System.out.println("1");
        	j++;
        	//break;
        case 2:
        	System.out.println("2");
        	j++;
        	//break;
        case 3:
        	System.out.println("3");
        	j++;
        	//break;
        case 4:
        	System.out.println("4");
        	j++;
        	//break;
        case 5:
        	System.out.println("5");
        	j++;
        	//break;
        default:
        	System.out.println("6");
        	j++;
        	//break;
        }
        return j+x;
    }
    
    @Test
    public void testDateFormatter() throws ParseException {
    	DateFormatter df = new DateFormatter("yyyy-MM-dd HH:mm:ss");
    	Date d = df.parse("2016-03-05 12:12:12", Locale.CHINA);
    	System.out.println(d);
    	
    	
    	System.out.println(df.print(new Date(), Locale.ITALY));
    }
 
}
