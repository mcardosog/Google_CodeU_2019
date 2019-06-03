package com.google.codeu.servlets;

import com.google.codeu.data.Datastore;
import com.google.codeu.data.ItemSchedule;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Handles fetching all schedule items for the public feed.
 */
@WebServlet("/schedulefeed")
public class ItemScheduleFeedServlet extends HttpServlet {

  private Datastore datastore;

  @Override
  public void init() {
    datastore = new Datastore();
  }

  /**
   * Responds with a JSON representation of schedule items data for all users.
   */
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {

    response.setContentType("application/json");
    List<ItemSchedule> items = datastore.getAllItemSchedule();
    response.getOutputStream().println(items.size());
    Gson gson = new Gson();

    String json = gson.toJson(items);
    response.getOutputStream().println(json + "\n");
    response.getOutputStream().println("HELLO");
    response.getOutputStream().println(datastore.getTotalItemScheduleCount());

  }
}
