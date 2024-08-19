package exceptions;

/**
 * The {@code FileException} class represents a custom exception
 * that is used to handle file-related errors in the application.
 * This class extends the {@code Exception} class and provides
 * multiple constructors for different use cases.
 * <p>
 * It can be used to signal various file handling issues, such as
 * problems with reading, writing, or accessing files.
 * </p>
 */


public class FileException extends Exception
{
    /**
     * Constructs a new {@code FileException} with {@code null}
     * as its detail message. The cause is not initialized, and may
     * subsequently be initialized by a call to {@link Throwable#initCause}.
     */
    public FileException()
    {
        super();
    }

    /**
     * Constructs a new {@code FileException} with the specified detail
     * message. The cause is not initialized, and may subsequently be
     * initialized by a call to {@link Throwable#initCause}.
     *
     * @param message the detail message (which is saved for later retrieval
     *                by the {@link Throwable#getMessage()} method).
     */
    public FileException(String message)
    {
        super(message);
    }

    /**
     * Constructs a new {@code FileException} with the specified detail
     * message and cause.
     * <p>Note that the detail message associated with {@code cause} is
     * not automatically incorporated in this exception's detail message.</p>
     *
     * @param message the detail message (which is saved for later retrieval
     *                by the {@link Throwable#getMessage()} method).
     * @param cause the cause (which is saved for later retrieval by the
     *              {@link Throwable#getCause()} method). A {@code null} value
     *              is permitted, and indicates that the cause is nonexistent
     *              or unknown.
     */
    public FileException(String message, Throwable cause)
    {
        super(message, cause);
    }

    /**
     * Constructs a new {@code FileException} with the specified cause and
     * a detail message of {@code (cause == null ? null : cause.toString())}
     * (which typically contains the class and detail message of {@code cause}).
     *
     * @param cause the cause (which is saved for later retrieval by the
     *              {@link Throwable#getCause()} method). A {@code null} value
     *              is permitted, and indicates that the cause is nonexistent
     *              or unknown.
     */
    public FileException(Throwable cause)
    {
        super(cause);
    }
}
