package homework;

import java.sql.Connection;

import javax.servlet.ServletContext;

import common.JDBConnect;


public class MemberShipDAO extends JDBConnect {


	public MemberShipDAO(String drv, String url, String id, String pw) {
		super(drv, url, id, pw);
	}
	public MemberShipDAO(ServletContext application) {
		super(application);
	}

	public int memberInsert(MembershipDTO dto) {
		
		//회원 가입을 위한 쿼리문 작성
		String query = "insert into membership (id,pass,name,birthday,zipcode,address,email,moblie,tel)"
				+ " values(?,?,?,?,?,?,?,?,?)";
		
		try {
			//쿼리문 실행을 위한 prepared객체 생성 및 인파라미터 설정
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getUserid());
			psmt.setString(2, dto.getPass());
			psmt.setString(3, dto.getName());
			psmt.setString(4, dto.getBirthday());
			psmt.setString(5, dto.getZipcode());
			psmt.setString(6, dto.getAddress());
			psmt.setString(7, dto.getEmail());
			psmt.setString(8, dto.getMoblie());
			psmt.setString(9, dto.getTel());

			return psmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
