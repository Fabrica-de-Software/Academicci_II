package academici.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import academici.entity.Monitoria;
import academici.persistence.CadastroDao;
import academici.persistence.MonitoriaDao;


public class MonitoriaSV extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");

        if (action.equals("novo")) {
            request.setAttribute("objMonitoria", new Monitoria());
            request.getRequestDispatcher("candidatarmonitoria.jsp").forward(request, response);
            return;
        }
        if (action.equals("listar")) {
            request.setAttribute("lstMonitoria", new MonitoriaDao().getMonitores());
            request.getRequestDispatcher("lstMonitoria.jsp").forward(request, response);
            return;
        }
        if (action.equals("salvar")) {
            if (save(request)) {
                request.setAttribute("msg", "Operação realizada com Sucesso!");
            } else {
                request.setAttribute("msg", "Ops!! Operação não realizada!");
            }
            request.setAttribute("objMonitoria", new Monitoria());
            request.getRequestDispatcher("candidatarmonitoria.jsp").forward(request, response);
            return;
        }

    }

    private boolean save(HttpServletRequest request) {

        Monitoria monitoria = new Monitoria();
        
   
        monitoria.setMatricula(Integer.parseInt(request.getParameter("matricula")));

        if (monitoria.getId() == 0) {
            return new MonitoriaDao().incluir(monitoria);
        } else {
            return new MonitoriaDao().alterar(monitoria);
        }

    }

}
