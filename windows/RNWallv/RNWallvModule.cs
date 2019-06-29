using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace Wallv.RNWallv
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNWallvModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNWallvModule"/>.
        /// </summary>
        internal RNWallvModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNWallv";
            }
        }
    }
}
