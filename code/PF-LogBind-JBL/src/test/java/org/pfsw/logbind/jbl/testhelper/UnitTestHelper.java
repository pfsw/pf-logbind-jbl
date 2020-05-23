package org.pfsw.logbind.jbl.testhelper;

import org.pfsw.logging.Logger;
import org.pfsw.logging.LoggerFactoryProvider;

public class UnitTestHelper
{
  private static final Logger LOG = LoggerFactoryProvider.getLogger(UnitTestHelper.class);

  public static void logAllLevels()
  {
    int value = 1;

    LOG.logDebug("Debug message {0}", value);
    LOG.logInfo("Debug message {0}", value);
    LOG.logWarning("Debug message {0}", value);
    LOG.logError("Debug message {0}", value);
    try
    {
      throw new IllegalArgumentException("Just a test");
    }
    catch (RuntimeException e)
    {
      LOG.logWarning("Problem: ", e);
      LOG.logError("Problem: ", e);
      LOG.logException(e);
    }
  }
}
