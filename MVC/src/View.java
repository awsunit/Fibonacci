public interface View {

  /**
   * tells the view to repaint and set it's model to the given model
   *
   * @param model The model to set as the view's model
   */
  void update(DrawingModel model);
}
