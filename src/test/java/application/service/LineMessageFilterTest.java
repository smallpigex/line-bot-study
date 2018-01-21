package application.service;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class LineMessageFilterTest {
  public LineMessageFilter filter;
  @Before
  public void setUp() throws Exception {
    filter = new LineMessageFilter();
  }

  @Test
  public void testIsRight() {
//    assertTrue(filter.isRightKey("餓惹 "));
  }
  
  @Test
  public void testIsNotRight() {
//    assertFalse(filter.isRightKey("a"));
//    
//    assertFalse(filter.isRightKey("a餓惹"));
//    
//    assertFalse(filter.isRightKey("a餓惹3"));
  }

}
