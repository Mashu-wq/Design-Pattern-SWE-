 interface Component{
    void render();//every components need a render method

}
 class Circle implements Component{
    private int radius;
    public int getRadius(){
        return radius;
    }
    public void setRadius(int radius){
        this.radius = radius;
    }
    @Override
    public void render(){
        System.out.println("Rendering a circle");
    }
}
 class ContextMenu{
    public void duplicate(Component component){
        if(component instanceof Circle){
            Circle source = (Circle)component;
            Circle target = new Circle();
            target.setRadius(source.getRadius());
        }
    }

}
public class vdoPrototypeXmple {
    
}
