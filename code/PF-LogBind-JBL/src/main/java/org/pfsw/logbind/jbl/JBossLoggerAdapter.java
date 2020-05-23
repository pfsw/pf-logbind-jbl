// ===========================================================================
// CONTENT  : CLASS JBossLoggerAdapter
// AUTHOR   : Manfred Duchrow
// VERSION  : 1.0 - 18/05/2020
// HISTORY  :
//  18/05/2020  mdu  CREATED
//
// Copyright (c) 2020, by MDCS. All rights reserved.
// ===========================================================================
package org.pfsw.logbind.jbl;

import java.text.MessageFormat;
import java.util.Properties;

import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;

/**
 * This adapter implements the PF {@link org.pfsw.logging.Logger} interface
 * and routes all logging to a JBoss logger. 
 *
 * @author Manfred Duchrow
 * @version 1.0
 */
public class JBossLoggerAdapter implements org.pfsw.logging.Logger
{
  private final Logger delegateLogger;

  public JBossLoggerAdapter(String loggerName)
  {
    super();
    this.delegateLogger = Logger.getLogger(loggerName);
  }

  public JBossLoggerAdapter(Class<?> clazz)
  {
    super();
    this.delegateLogger = Logger.getLogger(clazz);
  }

  @Override
  public String getName()
  {
    return getDelegateLogger().getName();
  }

  @Override
  public void logException(Throwable ex)
  {
    getDelegateLogger().trace("Exception: ", ex);
  }

  @Override
  public void logDebug(String message, Object... params)
  {
    if (isLoggingDebugs())
    {
      getDelegateLogger().debug(getLogMessage(message, params));
    }
  }

  @Override
  public void logInfo(String message, Object... params)
  {
    if (isLoggingInfos())
    {
      getDelegateLogger().info(getLogMessage(message, params));
    }
  }

  @Override
  public void logWarning(String message, Object... params)
  {
    if (isLoggingWarnings())
    {
      getDelegateLogger().warn(getLogMessage(message, params));
    }
  }

  @Override
  public void logError(String message, Object... params)
  {
    if (isLoggingErrors())
    {
      getDelegateLogger().error(getLogMessage(message, params));
    }
  }

  @Override
  public void logWarning(String message, Throwable exception)
  {
    getDelegateLogger().warn(message, exception);
  }

  @Override
  public void logError(String message, Throwable exception)
  {
    getDelegateLogger().error(message, exception);
  }

  @Override
  public boolean isLoggingDebugs()
  {
    return getDelegateLogger().isDebugEnabled();
  }

  @Override
  public boolean isLoggingInfos()
  {
    return getDelegateLogger().isInfoEnabled();
  }

  @Override
  public boolean isLoggingWarnings()
  {
    return getDelegateLogger().isEnabled(Level.WARN);
  }

  @Override
  public boolean isLoggingErrors()
  {
    return getDelegateLogger().isEnabled(Level.ERROR);
  }

  @Override
  public void initialize(Properties properties)
  {
    // not supported 
  }

  @Override
  public boolean setLogLevel(String level)
  {
    // Not supported
    return false;
  }

  protected String getLogMessage(String text, Object... params)
  {
    if ((params.length > 0) && (text.indexOf("{0") >= 0))
    {
      return MessageFormat.format(text, params);
    }
    return text;
  }

  protected Logger getDelegateLogger()
  {
    return this.delegateLogger;
  }
}
