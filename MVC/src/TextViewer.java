public class TextViewer implements View {

  @Override
  public void update(DrawingModel model) {
    for (Shape shape :
        model.getShapes()) {
      System.out.println(shape);
    }
  }


}
