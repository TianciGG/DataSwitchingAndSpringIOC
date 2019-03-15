package chauncy.reflect.entity;

/**
 * @classDesc: 功能描述(用户实体类)
 * @author: ChauncyWang
 * @createTime: 2019年3月15日 下午12:26:14
 * @version: 1.0
 */
public class UserEntity {

	private String userId;
	private String userName;

	public UserEntity() {
		System.out.println("使用反射机制执行无参构造函数");
	}

	public UserEntity(String userId) {
		System.out.println("使用反射机制执行有参构造函数--userId:" + userId);
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
