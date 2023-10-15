
import javax.swing.JTextArea;

// @author yamil
public class Ldo {

    NodoDoble lista;

    public void insertar(int val) {
        NodoDoble p = new NodoDoble(val);
        if (lista == null) {
            lista = p;
        } else {
            if (p.info < lista.info) {
                p.sig = lista;
                lista.ant = p;
                lista = p;
            } else {
                NodoDoble x = lista;
                while (x.sig != null && x.sig.info < p.info) {
                    x = x.sig;
                }
                p.sig = x.sig;
                p.ant = x;
                x.sig = p;
                if (p.sig != null) {
                    p.sig.ant = p;
                }
            }
        }
    }

    public NodoDoble buscar(int val) {
        NodoDoble x = lista;
        if (x != null) {
            if (x.info == val) {
                return x;
            } else {
                while (x.sig != null && x.sig.info < val) {
                    x = x.sig;
                }
            
            if (x.sig != null && x.sig.info == val) {
                return x.sig;
            }
                
            } 
            
        }
        return null;
    }

    public void elimina(int val) {
        NodoDoble x = buscar(val);
        if (x != null) {
            if (x == lista) {
                lista = x.sig;
            
            if (lista != null) {
                lista.ant = null;
            } }else {
                x.ant.sig = x.sig;
                if (x.sig != null) {
                    x.sig.ant = x.ant;
                }
            }
        }
    }
    public boolean busca(int val) {
        NodoDoble x = lista;

        if (x != null) {
            if (x.info == val) {
                return true;
            } else {
                while (x.sig != null && x.sig.info < val) {
                    x = x.sig;
                }
                if (x.sig != null && x.sig.info == val) {
                    return true;
                }
            }
        }
        return false;
    }

    public void imprime(JTextArea area) {
        NodoDoble x = lista;
        area.setText("");
        for (; x != null; x = x.sig) {
            area.append(x.info + "\n");
        }
    }
}
