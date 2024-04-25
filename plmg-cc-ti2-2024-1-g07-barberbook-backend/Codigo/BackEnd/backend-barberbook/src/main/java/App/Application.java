package App;

import static spark.Spark.*;
import service.UsersService; // Importe a classe UsersService
import service.StoresService; // Importe a classe StoresService

public class Application {

    private static UsersService UsersService = new UsersService(); // Instancie a classe UsersService
    private static StoresService storesService = new StoresService(); // Instancie a classe StoresService

    public static void main(String[] args) {
        port(6789);
        staticFiles.location("/public");

        // Configuração do CORS
        options("/*", (request, response) -> {
            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });

        before((request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Request-Method", "GET, POST, PUT, DELETE, OPTIONS");
            response.header("Access-Control-Allow-Headers", "Content-Type, Authorization, X-Requested-With");
        });

        // Definição dos endpoints para operações de usuários

        post("/users/insert", (request, response) -> UsersService.insert(request, response)); // Alterado para inserir um usuário
        get("/users/:id", (request, response) -> UsersService.get(request, response)); // Alterado para buscar um usuário pelo ID
        put("/users/update/:id", (request, response) -> UsersService.update(request, response)); // Alterado para atualizar um usuário
        delete("/users/delete/:id", (request, response) -> UsersService.delete(request, response)); // Alterado para deletar um usuário

        // Definição dos endpoints para operações de lojas
        post("/stores/insert", (request, response) -> storesService.insert(request, response));
        get("/stores/:id", (request, response) -> storesService.get(request, response));
        get("/stores/list/:orderby", (request, response) -> storesService.getAll(request, response));
        get("/stores/delete/:id", (request, response) -> storesService.delete(request, response));

    }
}
