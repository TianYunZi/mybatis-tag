import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.entitys.Product;
import com.entitys.Size;
import com.mapper.ProductMapper;

public class Test {

	public static void main(String[] args) throws IOException {
		Reader r = Resources.getResourceAsReader("Config.xml");
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(r);
		SqlSession session = factory.openSession();
		ProductMapper mapper = session.getMapper(ProductMapper.class);
//		Product p = mapper.selectOne(4);
//		System.out.println(p.getName()+"\t"+p.getKind()+"\t"+p.getPrice());
//		System.out.println("--------------------------------------------");
//		List<Size> sizes = p.getSizes();
//		for (Size size : sizes) {
//			System.out.println(size.getSname());
//		}
		
		Map<String,Object> cond = new HashMap<String,Object>();
		//cond.put("name", "a");
		//cond.put("price1",1);
		//cond.put("price2",10);
		int page = 3;
		int count = 5;
		int begin = (page-1)*count;
		cond.put("begin",begin);
		cond.put("count",count);
		List<Product> ps = mapper.selectAll(cond);
		for (Product p : ps) {
			System.out.println(p.getName());
			System.out.println("-----------------------------------");
			List<Size> sizes = p.getSizes();
			for (Size s : sizes) {
				System.out.println(s.getSname());
			}
			System.out.println("-----------------------------------");
		}
		session.close();
	}

}
