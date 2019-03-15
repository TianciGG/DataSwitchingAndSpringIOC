package chauncy.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import chauncy.reflect.entity.UserEntity;

/**
 * @classDesc: 功能描述(使用反射机制，调用类的无参、有参构造方法创建对象,使用反射获取该类的所有属性、方法(包含父类与不包含父类),使用反射机制访问不同包下类的私有成员变量)
 * @author: ChauncyWang
 * @createTime: 2019年3月15日 下午12:25:34
 * @version: 1.0
 */
public class ReflexMechanismApplication {
	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException, SecurityException {
		// 1.除了new创建对象，还可以使用反射机制创建对象。
		// UserEntity userEntity = new UserEntity();
		// 2.forName() 必须传入class类的完整路径。
		// 返回值就是对应类的字节码文件
		Class<?> forName = Class.forName("chauncy.reflect.entity.UserEntity");
		/*
		 * // 3.newInstance使用无参构造函数创建对象，等同于new 
		 * Object newInstance = forName.newInstance(); 
		 * UserEntity user = (UserEntity) newInstance;
		 * System.out.println("user:" + user); 
		 * user.setUserId("123");
		 * System.out.println(user.getUserId()); 
		 * // 使用反射技术和new哪个效率高？使用new效率高，因为反射需要读取class地址之后再执行一些列步骤 
		 * // 为什么有一些框架需要声明类的无参构造方法，如Hibernate框架实体类必须有无参构造方法，因为底层使用反射forName.newInstance()，不声明的话这句话会报错。
		 */
		
		
		/*//使用有参构造函数创建对象
		Constructor<?> constructor = forName.getConstructor(String.class);
		Object newInstance = constructor.newInstance("123");	
		UserEntity user=(UserEntity) newInstance;*/
		
		
		
		/*//使用反射获取该类的所有方法（不包含父类）
		Method[] declaredMethods = forName.getDeclaredMethods();
		for (Method method : declaredMethods) {
			System.out.println(method.getName()+"---------"+method.getReturnType());
		}*/
		
		/*//使用反射获取该类的所有成员属性（不包含父类）
		Field[] declaredFields = forName.getDeclaredFields();
		for (Field field : declaredFields) {
			System.out.println(field.getName());
		}*/
		
		
		/*//使用反射获取该类的所有方法（包含父类）
		Method[] declaredMethods = forName.getMethods();
		for (Method method : declaredMethods) {
			System.out.println(method.getName()+"---------"+method.getReturnType());
		}
		//Object类下有哪些方法？
		//wait---------void
		//wait---------void
		//wait---------void
		//equals---------boolean
		//toString---------class java.lang.String
		//hashCode---------int
		//getClass---------class java.lang.Class
		//notify---------void
		//notifyAll---------void
		 */		
		
		
		//可以使用反射机制访问到私有属性
		Field declaredFields = forName.getDeclaredField("userId");
		Object obj = forName.newInstance();
		//允许访问私有成员属性
		declaredFields.setAccessible(true);
		declaredFields.set(obj, "123");
		UserEntity user=(UserEntity) obj;
		System.out.println(user.getUserId());
	}
}
