package controle;

/**
 *
 * @author Uedney
 */
public class Config {

    private String host;
    private String banco;
    private String senha;
    private String login;
    private String porta;
    
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the porta
     */
    public String getPorta() {
        return porta;
    }

    /**
     * @param porta the porta to set
     */
    public void setPorta(String porta) {
        this.porta = porta;
    }
}
