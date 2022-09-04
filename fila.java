public class fila{
	
    public tipoNo cabeca;
    fila(){
        System.out.println("Criando fila...(construtor fila)");
    }

    public void insereInicio(String info){
       if(cabeca == null){ //nao tem ninguem na fila  
            cabeca = new tipoNo();
            cabeca.setInfo(info);
            cabeca.setProx(null);
       }else{
            tipoNo novo;
            novo = new tipoNo();
            novo.setInfo(info);
            novo.setProx(cabeca);
            cabeca = novo;
       }
    }	
    public void insereFinal(String info){
        if(cabeca == null){
            cabeca = new tipoNo();
            cabeca.setInfo(info);
            cabeca.setProx(null);
        }else{
            tipoNo aux,novo;
			
            novo = new tipoNo();
            novo.setInfo(info);
            novo.setProx(null);

            aux = cabeca;
            while (aux.getProx() != null) {
                aux = aux.getProx();
            }

            aux.setProx(novo);
	}
		
		System.out.println("Elemento "+info+" inserido com sucesso! ");
    }
	
    public void inserePosicaoEspecifica(String valor,int pos){
       if(pos == 1){ //insereInicio
          insereInicio(valor);
       }else{
          int cont=1;
          tipoNo aux=cabeca;
          while( cont != (pos-1) ){
             aux = aux.getProx();
             cont++;
          }
          tipoNo novo = new tipoNo();
          novo.setInfo(valor);
          novo.setProx(aux.getProx());
          aux.setProx(novo);
       }
    }
	
    public void removeInicio(){
        if(cabeca!=null){
            String valor = cabeca.getInfo();
            System.out.println("Elemento "+valor+" removido com sucesso! ");
            cabeca=cabeca.getProx();
	}
    }
	
     public void removeFinal(){
        if(cabeca==null){ //nao tem ninguem na lista
            System.out.println("Lista vazia!");
	}else if(cabeca.getProx() == null){ //tem apenas um elemento na lista
            String valor=cabeca.getInfo();
            System.out.println("Elemento "+valor+" removido com sucesso! ");
            cabeca=null; //cabeca=cabeca.getProx();    
        }else{ //mais de um elemento na lista
            tipoNo aux;
            aux = cabeca;
            while(aux.getProx().getProx() != null){
               aux = aux.getProx();
            }
            //tenho certeza que estou no penultimo
            aux.setProx(null);


        }
    }
	
    public void imprime(){
        tipoNo aux = cabeca;
        System.out.println("Impressao: ");
        while (aux != null) {
            System.out.print(aux.getInfo() + " ");
            aux = aux.getProx();
        }
        System.out.println("");
    }

    public void busca(String valor){
        tipoNo aux = cabeca;        
        while (aux != null && !aux.getInfo().equals(valor)) {
            aux = aux.getProx();         
        } 
        if(aux == null)
           System.out.println("Elemento "+valor+" não encontrado!");
        else
           System.out.println("Elemento "+valor+" encontrado!");
    }
	
    public void menu(){
        String valor;
        int opcao=0,pos;
	System.out.print("\n------------ Menu ------------\n");
	while(opcao!=-1){
            opcao = Input.readInt("\nDigite a opcao: "
                    + "\n(1) Insere no Inicio "
                    + "\n(2) Insere no Fim "
                    + "\n(3) Remove do Inicio "
                    + "\n(4) Remove do Fim "
                    + "\n(5) Imprime"
                    + "\n(6) Busca"
                    + "\n(7) Insere Posicao na Especifica"
                    + "\n(-1) Sair "
                    + "\nOpcao: ");
            switch(opcao){
			
                case 1: //insereInicio
                    valor = Input.readString("Valor: ");
                    insereInicio(valor);
		break;
				
		case 2: //insereFinal
                    valor = Input.readString("Valor: ");
                    insereFinal(valor);
		break;
				
		case 3: //removeInicio
                    removeInicio();
		break;
				
                case 4: //removeFinal
                    removeFinal();
		break;
				
		case 5: //imprime
                    imprime();
		break;
	        
                case 6:
                    valor = Input.readString("Valor: ");
                    busca(valor);
                break;

                case 7:
                    valor = Input.readString("Valor: ");
                    pos = Input.readInt("Pos: ");
                    inserePosicaoEspecifica(valor,pos);
                break;
		case -1: //sair
                    System.out.println("Saindo!");
		break;
				
		default:
                    System.out.println("Opcao invalida!");
		break;
			
            }
		
	}
    }

    public static void main(String args[]){
        System.out.println("\n************ Lista Encadeada Dinamica ************\n");
	fila F = new fila();
	F.menu();
	System.out.println("\n************ Fim programa ************\n");
    }
}