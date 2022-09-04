
public class tipoNo{
	public String info;
	public tipoNo prox;
	
	public tipoNo(){}
	
	public void setInfo(String info){
		this.info=info;
	}

	public void setProx(tipoNo prox){
		this.prox=prox;
	}
	
	public String getInfo(){
		return info;
	}
	public tipoNo getProx(){
		return prox;
	}

	
}