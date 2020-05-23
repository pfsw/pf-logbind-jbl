package org.pfsw.logbind.jbl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.pfsw.logbind.jbl.JBossLoggerAdapter;
import org.pfsw.logbind.jbl.testhelper.UnitTestHelper;
import org.pfsw.logging.Logger;
import org.pfsw.logging.Logger2;
import org.pfsw.logging.LoggerFactoryProvider;

/**
 * These tests will only be successful if the following system property is set:
 * <strong>-Dorg.pfsw.logging.binding=JBL</strong>
 */
public class JBossLoggerFactoryTest
{
  @Test
  public void test_binding__logger()
  {
    Logger logger = LoggerFactoryProvider.getLogger("test1");

    assertTrue(logger instanceof JBossLoggerAdapter);
    assertEquals("test1", logger.getName());
    assertFalse(logger.isLoggingDebugs());
    assertTrue(logger.isLoggingInfos());
    assertTrue(logger.isLoggingWarnings());
    assertTrue(logger.isLoggingErrors());
    logger.logInfo("Unittest <{0}>' was successful", "test_binding__logger()");
  }

  @Test
  public void test_binding__logger2()
  {
    Logger2 logger = LoggerFactoryProvider.getLogger2("test2");

    assertEquals("test2", logger.getLoggerName());
    assertFalse(logger.isDebugEnabled());
    assertFalse(logger.isInfoEnabled());
    assertTrue(logger.isWarnEnabled());
    assertTrue(logger.isErrorEnabled());
    logger.warnf("Unittest '%s' was successful", "test_binding__logger2()");
  }

  @Test
  public void test_binding__root_logger()
  {
    Logger logger = LoggerFactoryProvider.getLoggerFactory().createLogger();
    
    assertTrue(logger instanceof JBossLoggerAdapter);
    assertEquals("", logger.getName());
    assertFalse(logger.isLoggingDebugs());
    assertFalse(logger.isLoggingInfos());
    assertFalse(logger.isLoggingWarnings());
    assertTrue(logger.isLoggingErrors());
    logger.logError("Unittest {0} was successful", "test_binding__root_logger()");
  }
  
  @Test
  public void test_log_all_levels()
  {
    UnitTestHelper.logAllLevels();
  }
}