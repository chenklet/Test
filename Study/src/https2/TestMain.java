package https2;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class TestMain {
	private String url = "https://www.jd.com/";
	private String charset = "utf-8";
	private HttpClientUtil httpClientUtil = null;

	public TestMain() {
		httpClientUtil = new HttpClientUtil();
	}

	public void test() throws Exception{
		String httpOrgCreateTest = url;
		Map<String, String> createMap = new HashMap<String, String>();
		createMap.put("delivery_code", "1D1QZ222Z22SM21A");
		createMap.put("timestamp", "1479198840000");
		createMap.put("sign", "F2109C333F3EADE929F932E89703FA0F683D43EB");
		String httpOrgCreateTestRtn = httpClientUtil.doPost(httpOrgCreateTest,
				createMap, charset);
		PrintWriter p = new PrintWriter(new FileOutputStream("C:/Users/WQH/Desktop/test.txt"));
		p.print(httpOrgCreateTestRtn);
		p.flush();
		p.close();
//		System.out.println("result:" + httpOrgCreateTestRtn);
	}

	public static void main(String[] args) {
		TestMain main = new TestMain();
		try {
			main.test();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
