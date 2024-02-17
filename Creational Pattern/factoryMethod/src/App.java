import java.util.Map;
import java.util.HashMap;

class MatchaViewEngine{
    public String render(String viewName, Map<String, Object> context){
        return "View rendered by Matcha";
    }
    class Controller{
        public void render(String viewName, Map<String, Object> context, MatchaViewEngine matchaViewEngine){ 
            var engine = createViewEngine();
            var html = matchaViewEngine.render(viewName, context);
            System.out.println(html);

        }
    }
    protected ViewEngine createViewEngine(){
        return (MatchaViewEngine.ViewEngine) new MatchaViewEngine();
    }
    public class SharpViewEngine implements ViewEngine{
        public String render(String viewName, Map<String, Object> context){
            return "View rendered by Sharp";
        }
    }
    public class ProductsController extends Controller{
        public void listProducts(){
            //get products from a database
            Map<String, Object> context = new HashMap<>();
            //context.put(products)
            render("products.html", context, new MatchaViewEngine());
        }
    }
    interface ViewEngine{
        String render(String viewName, Map<String, Object> context);
    }
}