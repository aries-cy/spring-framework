package beanfactorypostprocessor.model;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

/**
 * 奔驰车
 *
 * @author cy
 */
public class BenzCar implements InitializingBean {

	private String desc;
	private String remark;


	public BenzCar(){
		System.out.println("1.BenzCar Constructor--无参构造器");
	}


	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("4.调用afterPropertiesSet方法");
		this.desc = "在初始化方法中修改之后的描述信息";
	}

	@PostConstruct
	public void postConstruct(){
		System.out.println("3.BenzCar postConstruct 初始化方法。");
	}

	public void initMethod() {
		System.out.println("5.调用initMethod方法");
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		System.out.println("调用setDesc方法");
		this.desc = desc;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		System.out.println("调用setRemark方法");
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "BenzCar{" +
				"desc='" + desc + '\'' +
				", remark='" + remark + '\'' +
				'}';
	}
}
