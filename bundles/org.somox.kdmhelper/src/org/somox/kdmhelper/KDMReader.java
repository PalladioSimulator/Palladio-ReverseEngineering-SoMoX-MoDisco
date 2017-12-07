package org.somox.kdmhelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.gmt.modisco.java.Model;
import org.eclipse.modisco.java.composition.javaapplication.JavaApplication;
import org.somox.kdmhelper.metamodeladdition.Root;

public final class KDMReader {

    static {
        org.eclipse.gmt.modisco.java.emf.JavaPackage.eINSTANCE.eClass();
        org.eclipse.gmt.modisco.omg.kdm.kdm.KdmPackage.eINSTANCE.eClass();
        org.eclipse.modisco.java.composition.javaapplication.JavaapplicationPackage.eINSTANCE.eClass();
    }

    public static final Root loadFile(final URI file) throws IOException {
        final Resource resource = loadModel(file);
        final Root root = new Root();
        root.addModels(getModelsFromResource(resource));
        return root;

    }

    private static Collection<Model> getModelsFromResource(final Resource resource) {
        final List<Model> modelList = new ArrayList<Model>();
        for (final EObject obj : resource.getContents()) {
            if (obj instanceof JavaApplication) {
                final JavaApplication javaApp = (JavaApplication) obj;
                for (final Object ref : javaApp.eCrossReferences()) {
                    if (ref instanceof Model) {
                        modelList.add((Model) ref);
                    }
                }
            }
        }
        return modelList;
    }

    private static Resource loadModel(final URI modelURI) throws IOException {
        final ResourceSet resourceSet = new ResourceSetImpl();
        String fileExtension = modelURI.fileExtension();
        if (fileExtension == null || fileExtension.length() == 0) {
            fileExtension = Resource.Factory.Registry.DEFAULT_EXTENSION;
        }

        final Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
        final Object resourceFactory = reg.getExtensionToFactoryMap().get(fileExtension);
        if (resourceFactory != null) {
            resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
            .put(fileExtension, resourceFactory);
        } else {
            resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
            .put(fileExtension, new XMIResourceFactoryImpl());
        }

        final Resource result = resourceSet.createResource(modelURI);
        if (result != null) {
            result.load(null);
        }
        return result;
    }
}