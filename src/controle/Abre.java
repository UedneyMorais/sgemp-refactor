//package controle;
//
//import javax.swing.JInternalFrame;
//
//
//import javax.swing.JInternalFrame;
//
//public class Abre {
//public static JInternalFrame JIpesquisa_cliente;//+
//public static JInternalFrame JIcad_venda;//+
////public static JInternalFrame JIcad_curso;//+
////public static JInternalFrame JIcad_fimcurso;//+
////public static JInternalFrame JIcad_fun;//+
////public static JInternalFrame JIcon_aluno;//+
////public static JInternalFrame JIcon_certificado;//+
////public static JInternalFrame JIcon_curso;//+
////public static JInternalFrame JIcon_fun;//+
////public static JInternalFrame JIdetalhe_aluno;//+
////public static JInternalFrame JIdetalhe_certificado;//+
////public static JInternalFrame JIdetalhe_curso;//+
////public static JInternalFrame JIdetalhe_matricula;//+
////public static JInternalFrame JIlougradouro;//+
////public static JInternalFrame JIpesquisa_aluno;//+
////public static JInternalFrame JIpesquisa_curso;//+
////public static JInternalFrame JIpesquisa_fun;//+
////public static JInternalFrame JIsobre;//+
////
////public static void pesquisa_cli()
////{
////    if (JIpesquisa_cliente==null || JIpesquisa_cliente.isVisible()==false)
////    {
////        JIpesquisa_cliente  = new visao.JIpesquisa_cliente();
////        visao.FrmPrincipal.jdarea.add(JIpesquisa_cliente);
////        JIpesquisa_cliente.setVisible(true);
////    }else
////    {
////        JIpesquisa_cliente.toFront();
////    }
////}
//
////public static void cadastro_venda()
////{
////    if (JIcad_venda==null || JIcad_venda.isVisible()==false)
////    {
////        JIcad_venda  = new visao.JIcad_venda();
////        visao.FrmPrincipal.jdarea.add(JIcad_venda);
////        JIcad_venda.setVisible(true);
////    }else
////    {
////        JIcad_venda.toFront();
////    }
//}
//
////
////public static void cadastro_curso()
////{
////    if (JIcad_curso==null || JIcad_curso.isVisible()==false)
////    {
////        JIcad_curso  = new tela.JIcad_curso();
////        tela.JFprincipal.jdarea.add(JIcad_curso);
////        JIcad_curso.setVisible(true);
////    }else
////    {
////        JIcad_curso.toFront();
////    }
////}
////
////public static void cadastro_fimcurso()
////{
////    if (JIcad_fimcurso==null || JIcad_fimcurso.isVisible()==false)
////    {
////        JIcad_fimcurso  = new tela.JIcad_fimcurso();
////        tela.JFprincipal.jdarea.add(JIcad_fimcurso);
////        JIcad_fimcurso.setVisible(true);
////    }else
////    {
////        JIcad_fimcurso.toFront();
////    }
////}
////
////public static void cadastro_funcionario()
////{
////    if (JIcad_fun==null || JIcad_fun.isVisible()==false)
////    {
////        JIcad_fun  = new tela.JIcad_fun();
////        tela.JFprincipal.jdarea.add(JIcad_fun);
////        JIcad_fun.setVisible(true);
////    }else
////    {
////        JIcad_fun.toFront();
////    }
////}
////
////public static void consulta_aluno()
////{
////    if (JIcon_aluno==null || JIcon_aluno.isVisible()==false)
////    {
////        JIcon_aluno  = new tela.JIcon_aluno();
////        tela.JFprincipal.jdarea.add(JIcon_aluno);
////        JIcon_aluno.setVisible(true);
////    }else
////    {
////        JIcon_aluno.toFront();
////    }
////}
////
////public static void consulta_certificado()
////{
////    if (JIcon_certificado==null || JIcon_certificado.isVisible()==false)
////    {
////        JIcon_certificado  = new tela.JIcon_certificado();
////        tela.JFprincipal.jdarea.add(JIcon_certificado);
////        JIcon_certificado.setVisible(true);
////    }else
////    {
////        JIcon_certificado.toFront();
////    }
////}
////
////public static void consulta_curso()
////{
////    if (JIcon_curso==null || JIcon_curso.isVisible()==false)
////    {
////        JIcon_curso  = new tela.JIcon_curso();
////        tela.JFprincipal.jdarea.add(JIcon_curso);
////        JIcon_curso.setVisible(true);
////    }else
////    {
////        JIcon_curso.toFront();
////    }
////}
////
////public static void consulta_funcionario()
////{
////    if (JIcon_fun==null || JIcon_fun.isVisible()==false)
////    {
////        JIcon_fun  = new tela.JIcon_fun();
////        tela.JFprincipal.jdarea.add(JIcon_fun);
////        JIcon_fun.setVisible(true);
////    }else
////    {
////        JIcon_fun.toFront();
////    }
////}
////
////public static void detalhe_aluno()
////{
////    if (JIdetalhe_aluno==null || JIdetalhe_aluno.isVisible()==false)
////    {
////        JIdetalhe_aluno  = new tela.JIdetalhe_aluno();
////        tela.JFprincipal.jdarea.add(JIdetalhe_aluno);
////        JIdetalhe_aluno.setVisible(true);
////    }else
////    {
////        JIdetalhe_aluno.toFront();
////    }
////}
////
////public static void detalhes_certificado()
////{
////    if (JIdetalhe_certificado==null || JIdetalhe_certificado.isVisible()==false)
////    {
////        JIdetalhe_certificado  = new tela.JIdetalhes_certificado();
////        tela.JFprincipal.jdarea.add(JIdetalhe_certificado);
////        JIdetalhe_certificado.setVisible(true);
////    }else
////    {
////        JIdetalhe_certificado.toFront();
////    }
////}
////
////public static void detalhes_curso()
////{
////    if (JIdetalhe_curso==null || JIdetalhe_curso.isVisible()==false)
////    {
////        JIdetalhe_curso  = new tela.JIdetalhes_curso();
////        tela.JFprincipal.jdarea.add(JIdetalhe_curso);
////        JIdetalhe_curso.setVisible(true);
////    }else
////    {
////        JIdetalhe_curso.toFront();
////    }
////}
////
////public static void detalhes_matricula()
////{
////    if (JIdetalhe_matricula==null || JIdetalhe_matricula.isVisible()==false)
////    {
////        JIdetalhe_matricula  = new tela.JIdetalhes_matricula();
////        tela.JFprincipal.jdarea.add(JIdetalhe_matricula);
////        JIdetalhe_matricula.setVisible(true);
////    }else
////    {
////        JIdetalhe_matricula.toFront();
////    }
////}
////
////public static void lougradouro()
////{
////    if (JIlougradouro==null || JIlougradouro.isVisible()==false)
////    {
////        JIlougradouro  = new tela.JIlougradouro();
////        tela.JFprincipal.jdarea.add(JIlougradouro);
////        JIlougradouro.setVisible(true);
////    }else
////    {
////        JIlougradouro.toFront();
////    }
////}
////
////public static void pesquisa_aluno()
////{
////    if (JIpesquisa_aluno==null || JIpesquisa_aluno.isVisible()==false)
////    {
////        JIpesquisa_aluno  = new tela.JIpesquisa_aluno();
////        tela.JFprincipal.jdarea.add(JIpesquisa_aluno);
////        JIpesquisa_aluno.setVisible(true);
////    }else
////    {
////        JIpesquisa_aluno.toFront();
////    }
////}
////
////public static void pesquisa_curso()
////{
////    if (JIpesquisa_curso==null || JIpesquisa_curso.isVisible()==false)
////    {
////        JIpesquisa_curso  = new tela.JIpesquisa_curso();
////        tela.JFprincipal.jdarea.add(JIpesquisa_curso);
////        JIpesquisa_curso.setVisible(true);
////    }else
////    {
////        JIpesquisa_curso.toFront();
////    }
////}
////
////public static void pesquisa_funcionario()
////{
////    if (JIpesquisa_fun==null || JIpesquisa_fun.isVisible()==false)
////    {
////        JIpesquisa_fun  = new tela.JIpesquisa_fun();
////        tela.JFprincipal.jdarea.add(JIpesquisa_fun);
////        JIpesquisa_fun.setVisible(true);
////    }else
////    {
////        JIpesquisa_fun.toFront();
////    }
////}
////
////public static void sobre_sistema()
////{
////    if (JIsobre==null || JIsobre.isVisible()==false)
////    {
////        JIsobre  = new tela.JIsobre();
////        tela.JFprincipal.jdarea.add(JIsobre);
////        JIsobre.setVisible(true);
////    }else
////    {
////        JIsobre.toFront();
////    }
////}
//}


