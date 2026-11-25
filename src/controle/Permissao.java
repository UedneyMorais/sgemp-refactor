package controle;

public class Permissao {
    
    Conexao connPermissao = new Conexao();

    public void permitir(String sql) {
        connPermissao.executaSQL(sql);
    }
}
