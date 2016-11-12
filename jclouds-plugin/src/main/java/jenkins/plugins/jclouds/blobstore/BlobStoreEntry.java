package jenkins.plugins.jclouds.blobstore;

import hudson.Extension;
import hudson.model.AbstractDescribableImpl;
import hudson.model.Descriptor;

import org.kohsuke.stapler.DataBoundConstructor;

/**
 * A simple "bean" for blobstore entries.
 *
 * @author Vijay Kiran
 */
public final class BlobStoreEntry extends AbstractDescribableImpl<BlobStoreEntry> {

    /**
     * The container where the file is saved. See http://www.jclouds.org/documentation/userguide/blobstore-guide#container
     */
    public final String container;

    /**
     * The sub path under the container where the file is saved.
     */
    public final String path;

    /**
     * The source file relative to the workspace directory, which needs to be uploaded to the container.
     */
    public final String sourceFile;

    /**
     * Whether or not the sourceFile's path relative to the workspace should be preserved upon upload to the Blobstore.
     */
    public final boolean keepHierarchy;

    /**
     * Whether an empty file is allowed without failing the build.
     */
    public final boolean allowEmptyFileset;

    /**
     * Whether to publish only for successful builds.
     */
    public final boolean onlyIfSuccessful;

    @DataBoundConstructor
    public BlobStoreEntry(final String container, final String path, final String sourceFile,
            final boolean keepHierarchy, final boolean allowEmptyFileset, final boolean onlyIfSuccessful) {
        this.container = container;
        this.path = path;
        this.sourceFile = sourceFile;
        this.keepHierarchy = keepHierarchy;
        this.allowEmptyFileset = allowEmptyFileset;
        this.onlyIfSuccessful = onlyIfSuccessful;
    }

    @Extension
    public static class DescriptorImpl extends Descriptor<BlobStoreEntry> {
        @Override
        public String getDisplayName() {
            return "";
        }
    }
}
