package org.pfsw.logbind.jbl;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;
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

    assertThat(logger instanceof JBossLoggerAdapter, is(true));
    assertThat(logger.getName(), is("test1"));
    assertThat(logger.isLoggingDebugs(), is(false));
    assertThat(logger.isLoggingInfos(), is(true));
    assertThat(logger.isLoggingWarnings(), is(true));
    assertThat(logger.isLoggingErrors(), is(true));
    logger.logInfo("Unittest <{0}>' was successful", "test_binding__logger()");
  }

  @Test
  public void test_binding__logger2()
  {
    Logger2 logger = LoggerFactoryProvider.getLogger2("test2");

    assertThat(logger.getLoggerName(), is("test2"));
    assertThat(logger.isDebugEnabled(), is(false));
    assertThat(logger.isInfoEnabled(), is(false));
    assertThat(logger.isWarnEnabled(), is(true));
    assertThat(logger.isErrorEnabled(), is(true));
    logger.warnf("Unittest '%s' was successful", "test_binding__logger2()");
  }

  @Test
  public void test_binding__root_logger()
  {
    Logger logger = LoggerFactoryProvider.getLoggerFactory().createLogger();

    assertThat(logger instanceof JBossLoggerAdapter, is(true));
    assertThat(logger.getName(), is(""));
    assertThat(logger.isLoggingDebugs(), is(false));
    assertThat(logger.isLoggingInfos(), is(false));
    assertThat(logger.isLoggingWarnings(), is(false));
    assertThat(logger.isLoggingErrors(), is(true));
    logger.logError("Unittest {0} was successful", "test_binding__root_logger()");
  }

  @Test
  public void test_log_all_levels()
  {
    UnitTestHelper.logAllLevels();
  }
}