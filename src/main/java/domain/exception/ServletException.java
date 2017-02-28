
package domain.exception;


public class ServletException extends Exception
{

    /**
     * Creates a new instance of <code>ServletException</code> without detail
     * message.
     */
    public ServletException()
    {
    }

    /**
     * Constructs an instance of <code>ServletException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ServletException(String msg)
    {
        super(msg);
    }
}
