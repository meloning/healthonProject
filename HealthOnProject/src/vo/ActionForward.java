package vo;
//��Ʈ�ѷ����� �����Ͻ� ������ ó���ϰ� �� �������� �������� �� �������� �ʿ��� ������ �����ϴ� Ŭ����
public class ActionForward {
	
	private String path;
	private boolean isRedirect;
	public ActionForward(){}
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public boolean isRedirect() {
		return isRedirect;
	}
	
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
	public ActionForward(String path, boolean isRedirect) {
		this.path = path;
		this.isRedirect = isRedirect;
	}
	
}