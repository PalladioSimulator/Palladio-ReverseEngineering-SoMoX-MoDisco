package org.somox.gast2seff.popup.actions;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class GAST2SEFFAction implements IObjectActionDelegate {

	private static final Logger logger = Logger.getLogger(GAST2SEFFAction.class);
	
	private ISelection selection;
	
	/**
	 * Constructor for Action1.
	 */
	public GAST2SEFFAction() {
		super();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		
		Job actionJob = new Job("GAST2SEFF") {
						
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				logger.error("Action Deprecated");				
				return Status.CANCEL_STATUS;
//				WorkflowExceptionHandler exceptionHandler = new UIBasedWorkflowExceptionHandler(false); 
//				IJob gast2seffJob;
				// gast2seffJob = new GAST2SEFFJob(getSAMInstanceURI());
//				Workflow workflow = new Workflow(gast2seffJob,monitor,exceptionHandler);
//				workflow.run();
				
//				monitor.done();
//				logger.info("finished GAST2SEFF");				
//				return Status.OK_STATUS;
			}			
		};
		IProgressMonitor pm = Job.getJobManager().createProgressGroup();
		pm.beginTask("GAST2SEFF", 1);
		logger.info("starting GAST2SEFF");
		actionJob.setProgressGroup(pm, 1);
		actionJob.schedule();

	}
	
	private URI getSAMInstanceURI () {
		TreeSelection selectedFile = (TreeSelection) selection;
		TreePath tp = selectedFile.getPaths()[0];
		IFile f = (IFile) tp.getLastSegment();
		return URI.createURI(f.getLocationURI().toString());
	}
	
	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

}
